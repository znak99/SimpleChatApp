//
//  SignupView.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

struct SignUpView: View {
    
    @State private var passwordCheck = ""
    @State private var buttonText = "Sign up"
    
    @StateObject var signUpManager: SignUpManager = .init()
    
    @Environment(\.dismiss) private var dismiss
    
    var body: some View {
        NavigationView {
            ZStack {
                Color.customBackground.ignoresSafeArea()
                GeometryReader { geo in
                    VStack {
                        VStack {
                            Text("Sign up for the app")
                                .font(.headline)
                                .fontWeight(.medium)
                        }
                        .foregroundColor(.customBlack)
                        .frame(maxWidth: .infinity)
                        .padding(.bottom, geo.size.height / 20)
                        .shadow(color: Color.customShadow, radius: 1)
                        InputField(
                            isSecureField: false, isEmailType: true,
                            placeholder: "Email", inputData:
                                $signUpManager.request.email
                        )
                        InputField(
                            isSecureField: false, isEmailType: false,
                            placeholder: "Username", inputData: $signUpManager.request.username
                        )
                        InputField(
                            isSecureField: true, isEmailType: false,
                            placeholder: "Password", inputData: $signUpManager.request.password
                        )
                        InputField(
                            isSecureField: true, isEmailType: false,
                            placeholder: "Password check", inputData: $passwordCheck
                        )
                        HStack {
                            if signUpManager.showWarnning {
                                Text("* \(signUpManager.message)")
                                    .font(.caption)
                                    .foregroundColor(.red)
                            }
                            
                            Spacer()
                        }
                        SubmitButton(buttonText: $buttonText) {
                            signUpManager.signUp()
                        }
                    }
                    .padding([.bottom, .horizontal])
                }
            }
            .alert(isPresented: $signUpManager.showSignUpSucceedAlert) {
                Alert(
                    title: Text("Signed up successfully"),
                    message: Text("Sign in on the sign in page"),
                    dismissButton: .default(Text("OK"), action: { dismiss() }))
            }
        }
    }
}

struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView()
    }
}
