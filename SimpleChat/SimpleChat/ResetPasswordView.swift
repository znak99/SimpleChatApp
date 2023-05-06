//
//  ResetPasswordView.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

struct ResetPasswordView: View {
    
    @State var email = ""
    @State var verificationCode = ""
    @State var buttonText = "Send verification code"
    @State var isSent = false
    
    var body: some View {
        NavigationView {
            ZStack {
                Color.customBackground.ignoresSafeArea()
                GeometryReader { geo in
                    VStack {
                        VStack {
                            Text("Enter the email address that you registered")
                                .font(.headline)
                                .fontWeight(.medium)
                        }
                        .foregroundColor(.customBlack)
                        .frame(maxWidth: .infinity)
                        .padding(.bottom, geo.size.height / 20)
                        .shadow(color: Color.customShadow, radius: 1)
                        
                        if isSent {
                            TextField("", text: $email)
                                .inputFieldModifier()
                                .disabled(true)
                                .overlay {
                                    RoundedRectangle(cornerRadius: 12)
                                        .stroke(Color.green)
                                }
                            InputField(
                                isSecureField: false, isEmailType: true,
                                placeholder: "Verification code", inputData: $verificationCode
                            )
                        } else {
                            InputField(
                                isSecureField: false, isEmailType: true,
                                placeholder: "Email", inputData: $email
                            )
                        }
                        
                        HStack {
                            Text("* Error Message")
                                .font(.caption)
                                .foregroundColor(.red)
                            Spacer()
                        }
                        SubmitButton(buttonText: $buttonText) {
                            print(email)
                            withAnimation {
                                isSent = true
                                buttonText = "Verify code"
                            }
                        }
                    }
                    .padding([.bottom, .horizontal])
                }
            }
        }
    }
}

struct ResetPasswordView_Previews: PreviewProvider {
    static var previews: some View {
        ResetPasswordView()
    }
}
