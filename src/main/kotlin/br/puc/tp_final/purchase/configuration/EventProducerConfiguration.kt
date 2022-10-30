package br.puc.tp_final.purchase.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val EXCHANGE_NAME = "storeExchange"
const val DELIVER_DISPATCH_QUEUE = "deliverDispatchDepartment"
const val STORE_QUEUE = "allEvents"

@Configuration
class EventProducerConfiguration {

    @Bean
    fun eventExchange(): TopicExchange {
        return TopicExchange(EXCHANGE_NAME, true, false)
    }

    @Bean(DELIVER_DISPATCH_QUEUE)
    fun deliverQueue(): Queue {
        return Queue(DELIVER_DISPATCH_QUEUE, true)
    }

    @Bean(STORE_QUEUE)
    fun storeQueue(): Queue {
        return Queue(STORE_QUEUE, true)
    }

    @Bean
    fun newDelivers(@Qualifier(DELIVER_DISPATCH_QUEUE) queue: Queue, eventExchange: TopicExchange): Binding {
        return BindingBuilder
            .bind(queue)
            .to(eventExchange)
            .with("store.deliver.#")
    }

    @Bean
    fun newBinding(@Qualifier(STORE_QUEUE) queue: Queue, eventExchange: TopicExchange): Binding {
        return BindingBuilder
            .bind(queue)
            .to(eventExchange)
            .with("store.#")
    }

    @Bean
    fun jackson2JsonMessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean("rabbitTemplateProducer")
    fun rabbitTemplateProducer(connectionFactory: ConnectionFactory, eventExchange: TopicExchange, jackson2JsonMessageConverter: Jackson2JsonMessageConverter): RabbitTemplate {
        var rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.setExchange(eventExchange.name)
        rabbitTemplate.messageConverter = jackson2JsonMessageConverter
        return rabbitTemplate
    }
}
