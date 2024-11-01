--INSERT INTO `espacio_fisico` (`capacidad`, `nombre`) VALUES (30, 'Aula 101'), (50, 'Laboratorio 202'), (100, 'Auditorio Principal');

--INSERT INTO `asignatura` (`nombre`, `codigo`) VALUES ('Mineria de datos', '1234'), ('Estructura de datos I', '1235'), ('Introducción a la ingenieria de sistemas', '1236');

INSERT INTO `docente`(`oficina_id`, `apellido`, `correo`, `nombre`) VALUES (NULL,'Masso','Jhon','jmasso@unicauca.edu.co');

INSERT INTO `docente` (`correo`, `apellido`, `nombre`, `oficina_id`, `id`) 
VALUES ('jmasso@unicauca.edu.co', 'Masso', 'Jhon', NULL, NULL);


--INSERT INTO `docente` (`id`, `correo`, `apellido`, `nombre`) VALUES (NULL, 'jmasso@unicauca.edu.co', 'Masso', 'Jhon');

--INSERT INTO `docente` (`correo`, `apellido`, `nombre`) VALUES ('jmasso@unicauca.edu.co', 'Masso', 'Jhon');