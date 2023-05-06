//
//  ViewExtension.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import SwiftUI

extension View {
    func inputFieldModifier() -> some View {
        self.modifier(InputFieldModifier())
    }
}
