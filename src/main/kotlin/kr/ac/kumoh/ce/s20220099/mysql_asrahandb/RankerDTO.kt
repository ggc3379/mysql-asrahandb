package kr.ac.kumoh.ce.s20220099.mysql_asrahandb.dto

data class RankerDTO(
    val rankerId: Int,
    val nickname: String,
    val fame: Int,
    val subclassName: String,
    val jobGroup: String?,
    val weaponName: String,
    val weaponType: String?,
    val legacyType: String?,
    val setName: String
)