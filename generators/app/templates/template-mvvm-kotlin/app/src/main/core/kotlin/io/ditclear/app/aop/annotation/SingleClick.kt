package <%= appPackage %>.aop.annotation

/**
 * Created by ditclear
 *
 * 防止View被快速点击
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class SingleClick
