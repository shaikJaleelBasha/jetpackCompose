package com.smad.compose_firebase.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState

    init {
        checkAuthStatus()
    }

    private fun checkAuthStatus() {
        _authState.value = if (auth.currentUser == null) AuthState.Unauthenticated else AuthState.Authenticated
    }

    fun login(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty")
            return
        }

        _authState.value = AuthState.Loading
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthState.Authenticated
                        onComplete(true, null)
                    } else {
                        val errorMsg = task.exception?.message ?: "Login failed"
                        _authState.value = AuthState.Error(errorMsg)
                        onComplete(false, errorMsg)
                    }
                }
        }
    }

    fun signup(email: String, password: String, onComplete: (Boolean, String?) -> Unit) {
        if (email.isEmpty() || password.isEmpty()) {
            _authState.value = AuthState.Error("Email or password can't be empty")
            return
        }

        _authState.value = AuthState.Loading
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthState.Authenticated
                        onComplete(true, null)
                    } else {
                        val errorMsg = task.exception?.message ?: "Signup failed"
                        _authState.value = AuthState.Error(errorMsg)
                        onComplete(false, errorMsg)
                    }
                }
        }
    }

    fun signout() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }
}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Error(val message: String) : AuthState()
}
