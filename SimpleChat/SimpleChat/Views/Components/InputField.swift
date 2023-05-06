//
//  InputField.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

struct InputField: View {
    
    let isSecureField: Bool
    let isEmailType: Bool
    @State var placeholder: String
    @Binding var inputData: String
    
    var body: some View {
        if isSecureField {
            SecureField(self.placeholder, text: $inputData)
                .inputFieldModifier()
        } else {
            TextField(self.placeholder, text: $inputData)
                .inputFieldModifier()
                .keyboardType(isEmailType ? .emailAddress : .default)
        }
    }
}

struct InputFieldModifier: ViewModifier {
    func body(content: Content) -> some View {
        content
            .font(.headline)
            .foregroundColor(.black)
            .padding()
            .autocorrectionDisabled(true)
            .textInputAutocapitalization(.never)
            .background(Color.customWhite)
            .cornerRadius(12)
    }
}


