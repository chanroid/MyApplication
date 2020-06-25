package co.kr.chanroid.myapplication.retrofit

data class Contacts(
    val contacts: List<Contact?>? = listOf()
) {
    data class Contact(
        val address: String? = "", // xx-xx-xxxx,x - street, x - country
        val email: String? = "", // ravi@gmail.com
        val gender: String? = "", // male
        val id: String? = "", // c200
        val name: String? = "", // Ravi Tamada
        val phone: Phone? = Phone()
    ) {
        data class Phone(
            val home: String? = "", // 00 000000
            val mobile: String? = "", // +91 0000000000
            val office: String? = "" // 00 000000
        )
    }
}