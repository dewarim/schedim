package de.schedim

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetails

class QuickStartController {

    def springSecurityService
    def userAccountService
    def authenticationManager

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def start() {
        def user = springSecurityService.currentUser
        log.debug("user: " + user)
        if (!user) {
            def username = UUID.randomUUID().toString() // TODO: generate cool username
            def password = 'hello'
            def email = 'schedim.registration@dewarim.de'
            def accountResult = userAccountService.createUserAccount(username, password, email)
            def newAccount = accountResult.userAccount
            newAccount.enabled = true
            newAccount.save(flush: true)

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authenticatedUser = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            user = springSecurityService.currentUser
            log.debug("new user: " + user)
        }
        return [user: user]
    }


}
