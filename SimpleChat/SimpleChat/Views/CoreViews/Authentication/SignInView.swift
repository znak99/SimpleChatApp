//
//  LoginView.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

struct SignInView: View {
    
    @State private var email = ""
    @State private var password = ""
    @State private var buttonText = "Sign in"
    
    @StateObject var signInManager: SignInManager = .init()
    
    @Environment(\.dismiss) private var dismiss
    
    var body: some View {
        NavigationView {
            ZStack {
                Color.customBackground.ignoresSafeArea()
                GeometryReader { geo in
                    VStack {
                        VStack {
                            Text("Welcome!")
                                .font(.largeTitle)
                                .fontWeight(.bold)
                            Text("Sign in to use chat")
                                .font(.headline)
                                .fontWeight(.medium)
                        }
                        .foregroundColor(.customBlack)
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, geo.size.height / 20)
                        .shadow(color: Color.customShadow, radius: 1)
                        
                        InputField(
                            isSecureField: false, isEmailType: true,
                            placeholder: "Email", inputData: $signInManager.request.email
                        )
                        InputField(
                            isSecureField: true, isEmailType: false,
                            placeholder: "Password", inputData: $signInManager.request.password
                        )
                        
                        HStack {
                            Text("* \(signInManager.message)")
                                .font(.caption)
                                .foregroundColor(.red)
                            Spacer()
                        }
                        HStack {
                            Spacer()
                            NavigationLink(destination: ResetPasswordView()) {
                                HStack {
                                    Text("Forgot password?")
                                        .font(.subheadline)
                                    Image(systemName: "magnifyingglass")
                                }
                                .foregroundColor(.customBlack)
                                .underline()
                            }
                        }
                        SubmitButton(buttonText: $buttonText) {
                            print(email)
                            print(password)
                        }
                        
                        Text("First time to visit this app?")
                            .foregroundColor(.black)
                            .font(.subheadline)
                        NavigationLink(destination: SignUpView()) {
                            Text("Register now")
                                .foregroundColor(.blue)
                                .font(.headline)
                        }
                        
                    }
                    .padding()
                }
            }
            .navigationTitle("Sign in")
            .toolbar(.hidden)
        }
        .onReceive(signInManager.$isSignedIn) { succeed in
            if succeed {
                dismiss()
            }
        }
    }
}

struct SignInView_Previews: PreviewProvider {
    static var previews: some View {
        SignInView()
    }
}
