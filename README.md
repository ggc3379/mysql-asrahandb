# 2025 데이터 베이스 TermProject

```mermaid

erDiagram
    Ranker }o--|| Subclass : "belongs to"
    Ranker }o--|| Weapon : "uses"
    Ranker }o--|| EquipmentSet : "equipped with"

    Ranker {
        int rankerId PK
        string nickname
        int subclassId FK
        int weaponId FK
        int setId FK
        int fame
    }

    Subclass {
        int subclassId PK
        string subclassName
        string jobGroup
    }

    Weapon {
        int weaponId PK
        string weaponName
        string weaponType
        string legacyType
    }

    EquipmentSet {
        int setId PK
        string setName
    }
