package br.com.cwi.crescer.melevaai.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider provider;

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
                .ignoring()
                .antMatchers("/*/publico/**");
    }

    private static final RequestMatcher PRIVATE_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/*/privado/**")
    );

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .exceptionHandling()
                .and()
                .authenticationProvider(provider)
                .addFilterBefore(tokenFilter(), AnonymousAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers(PRIVATE_URLS)
                .authenticated()
                .and()
                .csrf().disable()
        ;
    }

    @Bean
    AuthenticationFilter tokenFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter(PRIVATE_URLS);
        filter.setAuthenticationManager(authenticationManager());

        return filter;
    }
}
