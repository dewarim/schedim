package de.schedim

import de.dewarim.goblin.combat.Combat
import de.dewarim.goblin.mob.Mob
import de.dewarim.goblin.mob.MobTemplate
import de.dewarim.goblin.pc.PlayerCharacter
import grails.transaction.Transactional

@Transactional
class CombatService {

    def createCombat(PlayerCharacter pc) {
        def mobTemplate = selectRandomMobType()
        Mob mob = new Mob(name: mobTemplate.name, type: mobTemplate)
        mob.initMob()
        mob.save()
        def combat = new Combat(pc, mob)
        combat.save()
        return combat
    }

    private MobTemplate selectRandomMobType() {
        List<MobTemplate> mtList = MobTemplate.list()
        return mtList.get((Integer) (Math.random() * mtList.size()))
    }

}
