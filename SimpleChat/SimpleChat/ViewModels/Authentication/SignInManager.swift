//
//  SignInManager.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/07.
//

import Foundation

class SignInManager: ObservableObject {
    @Published var request: SignInRequest = .init(email: "", password: "")
    @Published var showWarnning: Bool = false
    @Published var message: String = ""
    @Published var isProgressing: Bool = false
    @Published var isSignedIn = false
    
    func signUp() {
        if isProgressing {
            return
        }
        isProgressing = true
        Authenticator.shared.signIn(
            email: request.email,
            password: request.password) { success, message, userInfo in
                DispatchQueue.global(qos: .background).async {
                    DispatchQueue.main.async {
                        if success {
                            if let userInfo {
                                UserDefaults.standard.set(userInfo, forKey: "session")
                                self.isSignedIn = true
                            } else {
                                self.message = "Failed to load user info"
                                self.showWarnning = true
                            }
                        } else {
                            if let message {
                                self.message = message
                            }
                            self.showWarnning = true
                        }
                    }
                }
        }
    }
}
