//
//  SignUpManager.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import Foundation

class SignUpManager: ObservableObject {
    @Published var request: SignUpRequest = .init(email: "", username: "", password: "")
    @Published var showSignUpSucceedAlert: Bool = false
    @Published var showWarnning: Bool = false
    @Published var message: String = ""
    @Published var isProgressing: Bool = false
    
    func signUp() {
        if isProgressing {
            return
        }
        isProgressing = true
        Authenticator.shared.signUp(
            email: request.email,
            username: request.username,
            password: request.password) { success, message in
                DispatchQueue.global(qos: .background).async {
                    DispatchQueue.main.async {
                        if success {
                            self.showSignUpSucceedAlert.toggle()
                        } else {
                            if let message = message {
                                self.message = message
                            }
                            self.showWarnning = true
                        }
                        self.isProgressing = false
                    }
                }
        }
    }
}
