package kr.ac.kumoh.ce.s20220099.mysql_asrahandb

import jakarta.persistence.*

@Entity
@Table(name = "Subclasses")
data class Subclass(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val subclassId: Int = 0,

    @Column(nullable = false)
    val subclassName: String,

    val jobGroup: String? = null
)

@Entity
@Table(name = "Weapons")
data class Weapon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val weaponId: Int = 0,

    @Column(nullable = false)
    val weaponName: String,

    val weaponType: String? = null,
    val legacyType: String? = null
)

@Entity
@Table(name = "Sets")
data class EquipmentSet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val setId: Int = 0,

    @Column(nullable = false)
    val setName: String
)

@Entity
@Table(name = "Rankers")
data class Ranker(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val rankerId: Int = 0,

    @Column(nullable = false)
    val nickname: String,

    @ManyToOne
    @JoinColumn(name = "subclass_id", nullable = false)
    val subclass: Subclass,

    @ManyToOne
    @JoinColumn(name = "weapon_id", nullable = false)
    val weapon: Weapon,

    @ManyToOne
    @JoinColumn(name = "set_id", nullable = false)
    val equipmentSet: EquipmentSet,

    @Column(nullable = false)
    val fame: Int
)
