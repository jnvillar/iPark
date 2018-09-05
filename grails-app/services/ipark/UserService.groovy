package ipark

class UserService {

    def get(Long id){
        User.findById(id)
    }
}
