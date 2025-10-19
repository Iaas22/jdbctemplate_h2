JDBCTEMPLATE H2

1. Inicializar base de datos
Muestra un mensaje de exito de base de datos al hacer la petición, esto significa que se ha creado la tabla de customers con los datos insertados por defecto. 
![image alt](https://github.com/Iaas22/jdbctemplate_h2/blob/main/inicializarBD.png?raw=true)

2. Mostrar todos los customers
Hago la petición findAllCustomers,d evuelve un JSON con todos los customers y sus datos.
Esto ocurre porque la función findAllCustomers consulta la tabla customers y devuelve todos los registros que existen actualmente en la base de datos.
![image alt](https://github.com/Iaas22/jdbctemplate_h2/blob/main/findAllCustomers.png?raw=true)

3. Crear un customer
Hay que insertar un json con los datos del customer, en este caso age, cicle  y year. 
El mensaje "customer creado" indica que los datos enviados en el JSON se han insertado correctamente en la base de datos y se ha creado un nuevo registro en la tabla customers.
![image alt](https://github.com/Iaas22/jdbctemplate_h2/blob/main/addCustomer.png?raw=true)




