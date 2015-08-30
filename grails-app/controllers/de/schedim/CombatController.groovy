package de.schedim

import de.dewarim.goblin.BaseController
import de.dewarim.goblin.combat.Combat
import grails.plugin.springsecurity.annotation.Secured

/**
 * Manages fights for Schedim. This replaces the Goblin.FightController, as I want a simpler combat structure
 * that is free from connections to quests and also redirects the user to Schedim's own controllers. 
 */
class CombatController {
    
    def combatService

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def fight(){
        def pc = session.pc
        if (!pc){
            return redirect(controller: 'quickStart', action: 'landing')
        }
        
        Combat combat = pc.currentCombat
        if(!combat){
            pc.currentCombat = combatService.createCombat(pc)
        }
        return [pc:pc, mob:pc.currentCombat.mobs.first()]
    }
    
}
