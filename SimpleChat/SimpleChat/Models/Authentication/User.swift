//
//  User.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import Foundation

struct User: Codable {
    let id: Int
    var email: String
    var username: String
    var password: String
    var chatId: String
    var profileImageUrl: String
    var friendsList: [String]
}
