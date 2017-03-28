TASK

@Entity
public class Event {
    private long id;
    private String name;
    private String location;
    private Date dateFrom;
    private Date dateTo;
    
@Entity
public class Router {
    private long id;
    private String apMac;
    private String routerName;

Даны два entity. Cвязь между ними  One to Many (Один Event может иметь Много Router).
Необходимо реализовать CRUD операции для этих таблиц.
Технологии:  
		●  Spring MVC 4+  
		●  ORM библиотека Hibernate 4+ 
		●  СУБД MySQL  
		●  Шаблонизатор JSP



