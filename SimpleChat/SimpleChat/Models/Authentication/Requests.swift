//
//  UserRegistration.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import Foundation

struct SignUpRequest: Codable {
    var email: String
    var username: String
    var password: String
}

struct SignInRequest: Codable {
    var email: String
    var password: String
}
