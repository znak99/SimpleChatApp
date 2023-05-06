//
//  UserRegistration.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import Foundation

struct UserRegistration: Codable {
    let id: UUID = UUID()
    var email: String
    var username: String
    var password: String
}
