//
//  SubmitButton.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

struct SubmitButton: View {
    
    @Binding var buttonText: String
    @State var action: () -> Void
    
    var body: some View {
        Button(action: { action() }) {
            Text(buttonText)
                .foregroundColor(.white)
                .font(.headline)
                .frame(maxWidth: .infinity)
        }
        .padding(.vertical, 16)
        .background(Color.customBlack)
        .cornerRadius(12)
        .shadow(color: Color.customShadow, radius: 2, y: 1)
        .padding(.vertical)
    }
}
