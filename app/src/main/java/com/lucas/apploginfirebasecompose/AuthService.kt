package com.lucas.apploginfirebasecompose

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

object AuthService {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Retorna usuário atual, se tiver logado
    val currentUser: FirebaseUser?
        get() = auth.currentUser

    // Função de Login
    fun login(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    // Função de Cadastro
    fun register(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    // Função de Logout
    fun logout() {
        auth.signOut()
    }
}
