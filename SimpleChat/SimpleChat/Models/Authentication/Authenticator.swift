//
//  UserService.swift
//  SimpleChat
//
//  Created by seungwoo on 2023/05/06.
//

import Foundation

class Authenticator {
    static let shared = Authenticator()
    
    private var host = "http://localhost"
    
    func signUp(email: String, username: String, password: String, completion: @escaping (Bool, String?) -> Void) {
        guard let url = URL(string: "\(host)/api/signup") else {
            completion(false, nil)
            return
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.addValue("application/json", forHTTPHeaderField: "Content-Type")
        
        let parameters: [String: Any] = [
            "email": email,
            "username": username,
            "password": password
        ]
        request.httpBody = try? JSONSerialization.data(withJSONObject: parameters)
        
        let task = URLSession.shared.dataTask(with: request) { (data, response, error) in
            guard let data = data else {
                completion(false, nil)
                return
            }
            
            do {
                let signUpResponse = try JSONDecoder().decode(SignUpResponse.self, from: data)
                completion(signUpResponse.success, signUpResponse.message)
            } catch {
                print("JSON decoding error: \(error)")
                completion(false, nil)
            }
        }
        task.resume()
    }
    
    func signIn(email: String, password: String, completion: @escaping (Bool) -> Void) {
        
    }
    
    func sendEmail(email: String, completion: @escaping (Bool) -> Void) {
        
    }
    
    func verifyCode(code: String, completion: @escaping (Bool) -> Void) {
        
    }
    
    func resetPassword(password: String, completion: @escaping (Bool) -> Void) {
        
    }
}
