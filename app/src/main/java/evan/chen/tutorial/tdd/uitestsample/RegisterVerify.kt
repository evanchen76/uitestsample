package evan.chen.tutorial.tdd.uitestsample

class RegisterVerify {

    fun isLoginIdVerify(loginId: String): Boolean {
        var isLoginIdOK = false
        //帳號至少6碼，第1碼為英文，j
        if (loginId.length >= 6) {
            if (loginId.toUpperCase().first() in 'A'..'Z') {
                isLoginIdOK = true
            }
        }
        return isLoginIdOK
    }

    fun isPasswordVerify(pwd: String): Boolean {
        var isPwdOK = false
        if (pwd.length >= 8) {
            if (pwd.toUpperCase().first() in 'A'..'Z') {
                if (pwd.findAnyOf((0..9).map { it.toString() }) != null) {
                    isPwdOK = true
                }
            }
        }
        return isPwdOK
    }
}