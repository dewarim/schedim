import de.dewarim.goblin.Dice
import de.dewarim.goblin.mob.MobTemplate

class BootStrap {

    def init = { servletContext ->
        
        def d20 = null
        def d1 = null
        if(!Dice.count ){
            d20 = new Dice(name: 'd20', amount: 20)
            d20.save()
            d1 = new Dice(name: 'd1')
            d1.save()
        }
        if (!MobTemplate.count) {
            def mob = new MobTemplate(name:'Grub the Halfling runt', 
                    maxHp: 1, gold:1, male:true, description: 'An evil little halfling, twisted by envy of all the ' +
                    'more powerful monsters who look down upon him.', // TODO: use message.property
                    strike: d20, parry: d20, initiative: d20, damage: d1
            )
            mob.save()
        }

    }
    def destroy = {
    }
}
