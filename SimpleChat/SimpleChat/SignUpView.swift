//
//  SignupView.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

struct SignUpView: View {
    
    @State private var email = ""
    @State private var username = ""
    @State private var password = ""
    @State private var passwordCheck = ""
    @State private var buttonText = "Sign up"
    
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
                            placeholder: "Email", inputData: $email
                        )
                        InputField(
                            isSecureField: false, isEmailType: false,
                            placeholder: "Username", inputData: $username
                        )
                        InputField(
                            isSecureField: true, isEmailType: false,
                            placeholder: "Password", inputData: $password
                        )
                        InputField(
                            isSecureField: true, isEmailType: false,
                            placeholder: "Password check", inputData: $passwordCheck
                        )
                        HStack {
                            Text("* Error Message")
                                .font(.caption)
                                .foregroundColor(.red)
                            Spacer()
                        }
                        SubmitButton(buttonText: $buttonText) {
                            print(email)
                            print(username)
                            print(password)
                            print(passwordCheck)
                        }
                    }
                    .padding([.bottom, .horizontal])
                }
            }
        }
    }
}

struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView()
    }
}
