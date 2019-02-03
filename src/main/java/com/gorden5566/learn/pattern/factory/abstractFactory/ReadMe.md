## description
Provide an interface for creating families of related or dependent objects without specifying
their concrete classes.

## 说明
为创建一组相关或相互依赖的对象提供一个接口， 而且无须指定它们的具体类。 

## 缺点
产品族扩展困难。比如在产品族里增加一个产品C，需要修改抽象类AbstractCreator，并且对应的实现类也需要修改。这违反了开闭原则。
