open class Warrior() {
    fun attack() {
        println("공격")
    }
}

class DefenseWarrior() : Warrior() {
    fun defense() {
        println("방어")
    }
}

class HardAttackWarrior() : Warrior() {
    fun HardAttack() {
        println("강한 공격")
    }
}

val defenseWarrior: DefenseWarrior = DefenseWarrior()
defenseWarrior.attack()
defenseWarrior.defense()

open class Warrior1(var name: String, var power: Int, var gender: String) {
    fun attack() {
        println("공격")
    }
}

class DefenseWarrior1 constructor(name: String, power: Int) : Warrior1(name, power, "여성") {
    fun defense() {
        println("방어")
    }
}

class HardAttackWarrior1 : Warrior1 {
    var bonusPower: Int = 0
    constructor(name: String, power: Int, bonusPower: Int): super(name, power, "골렘") {
        this.bonusPower = bonusPower
    }
    fun hardAttack() {
        println("$bonusPower 어택")
    }
}

val defenseWarrior1: DefenseWarrior1() = DefenseWarrior1("고블", 100)
defenseWarrior1.attack()
defenseWarrior1.defense()
val hardAttackWarrior1: HardAttackWarrior1 = HardAttackWarrior1("골렘", 100, 20)
hardAttackWarrior1.attack()
hardAttackWarrior1.hardAttack()
