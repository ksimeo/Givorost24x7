package com.ksimeo.givorost.admin.config;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/orders/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/products/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//                .and().formLogin();
//
////        http.requiresChannel().antMatchers("/showorderspage/**").requiresSecure();
//
//    }
//}
