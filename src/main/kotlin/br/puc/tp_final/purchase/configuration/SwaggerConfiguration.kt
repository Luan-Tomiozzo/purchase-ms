package br.puc.tp_final.purchase.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.builders.ApiInfoBuilder

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    open fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.puc.tp_final.purchase"))
        .paths(PathSelectors.any())
        .build()

    private fun getApiInfo(): ApiInfo {
        val contact = Contact(
            "Caio, Daniel, Eduardo Augusto, Kauane, Luan, Paulo, Rafael, Ricardo",
            "Trabalho Java",
            "Arquitetura"
        )
        return ApiInfoBuilder()
            .title("Api Purchase")
            .description("Api Definition")
            .version("1.0.0")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .contact(contact)
            .build()
    }
}