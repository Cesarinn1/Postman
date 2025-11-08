# Guia Paso a Paso para Probar el Servicio SOAP con POSTMAN

## Requisito Previo
Asegurate de que el servicio este corriendo en `http://localhost:8080`

## OPCION 1: Configuracion Manual en Postman

### Paso 1: Crear Nueva Request
1. Abre Postman
2. Click en "New" -> "HTTP Request"
3. Cambia el metodo a **POST**
4. URL: `http://localhost:8080/ws`

### Paso 2: Configurar Headers
En la pestana "Headers", agrega:

| Key | Value |
|-----|-------|
| Content-Type | text/xml |
| SOAPAction | "" |

### Paso 3: Configurar Body
1. Ve a la pestana "Body"
2. Selecciona "raw"
3. En el dropdown de la derecha, selecciona "XML"
4. Copia y pega uno de los ejemplos de abajo

---

## EJEMPLOS DE PETICIONES SOAP

### PRUEBA 1: Login Exitoso con usuario "admin"

**Body (XML):**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://www.example.com/soap-login-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:LoginRequest>
         <soap:username>admin</soap:username>
         <soap:password>admin123</soap:password>
      </soap:LoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Respuesta Esperada (Status 200 OK):**
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:LoginResponse xmlns:ns2="http://www.example.com/soap-login-service">
         <ns2:status>SUCCESS</ns2:status>
         <ns2:message>Login exitoso. Bienvenido admin!</ns2:message>
      </ns2:LoginResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### PRUEBA 2: Login Exitoso con usuario "user"

**Body (XML):**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://www.example.com/soap-login-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:LoginRequest>
         <soap:username>user</soap:username>
         <soap:password>user123</soap:password>
      </soap:LoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Respuesta Esperada (Status 200 OK):**
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:LoginResponse xmlns:ns2="http://www.example.com/soap-login-service">
         <ns2:status>SUCCESS</ns2:status>
         <ns2:message>Login exitoso. Bienvenido user!</ns2:message>
      </ns2:LoginResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### PRUEBA 3: Login Exitoso con usuario "test"

**Body (XML):**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://www.example.com/soap-login-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:LoginRequest>
         <soap:username>test</soap:username>
         <soap:password>test123</soap:password>
      </soap:LoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Respuesta Esperada (Status 200 OK):**
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:LoginResponse xmlns:ns2="http://www.example.com/soap-login-service">
         <ns2:status>SUCCESS</ns2:status>
         <ns2:message>Login exitoso. Bienvenido test!</ns2:message>
      </ns2:LoginResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### PRUEBA 4: Login Fallido - Usuario Incorrecto

**Body (XML):**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://www.example.com/soap-login-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:LoginRequest>
         <soap:username>usuario_invalido</soap:username>
         <soap:password>admin123</soap:password>
      </soap:LoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Respuesta Esperada (Status 200 OK):**
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:LoginResponse xmlns:ns2="http://www.example.com/soap-login-service">
         <ns2:status>FAILURE</ns2:status>
         <ns2:message>Usuario o contrasena incorrectos</ns2:message>
      </ns2:LoginResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### PRUEBA 5: Login Fallido - Contrasena Incorrecta

**Body (XML):**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://www.example.com/soap-login-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:LoginRequest>
         <soap:username>admin</soap:username>
         <soap:password>contrasena_incorrecta</soap:password>
      </soap:LoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Respuesta Esperada (Status 200 OK):**
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:LoginResponse xmlns:ns2="http://www.example.com/soap-login-service">
         <ns2:status>FAILURE</ns2:status>
         <ns2:message>Usuario o contrasena incorrectos</ns2:message>
      </ns2:LoginResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

### PRUEBA 6: Login Fallido - Ambos Incorrectos

**Body (XML):**
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:soap="http://www.example.com/soap-login-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:LoginRequest>
         <soap:username>hacker</soap:username>
         <soap:password>12345</soap:password>
      </soap:LoginRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

**Respuesta Esperada (Status 200 OK):**
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:LoginResponse xmlns:ns2="http://www.example.com/soap-login-service">
         <ns2:status>FAILURE</ns2:status>
         <ns2:message>Usuario o contrasena incorrectos</ns2:message>
      </ns2:LoginResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

---

## OPCION 2: Importar WSDL en Postman

Postman puede generar automaticamente las requests desde el WSDL:

1. Click en "Import" en Postman
2. Selecciona "Link"
3. Pega: `http://localhost:8080/ws/login.wsdl`
4. Click en "Continue" y luego "Import"
5. Postman creara automaticamente las requests basadas en el WSDL

---

## Verificaciones Importantes

### 1. Verificar que el servicio este corriendo
Antes de probar, verifica que el WSDL este accesible:
- Abre en el navegador: `http://localhost:8080/ws/login.wsdl`
- Deberias ver el XML del WSDL

### 2. Verificar Headers en Postman
Asegurate de tener estos headers exactamente:
```
Content-Type: text/xml
SOAPAction: ""
```

### 3. Verificar el Body
- El formato debe ser XML (raw)
- El namespace debe ser correcto: `xmlns:soap="http://www.example.com/soap-login-service"`
- El envelope debe tener el namespace SOAP correcto: `xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"`

---

## Errores Comunes y Soluciones

### Error 404 - Not Found
**Causa**: El servicio no esta corriendo o la URL es incorrecta
**Solucion**: Verifica que el servicio este corriendo en `http://localhost:8080`

### Error 500 - Internal Server Error
**Causa**: XML mal formado o namespaces incorrectos
**Solucion**: Copia exactamente uno de los ejemplos de arriba

### No recibo respuesta
**Causa**: Headers incorrectos
**Solucion**: Verifica que Content-Type sea `text/xml` y SOAPAction sea `""`

### Respuesta vacia
**Causa**: Endpoint incorrecto
**Solucion**: La URL debe ser `http://localhost:8080/ws` (sin login.wsdl al final)

---

## Tips para la Demostracion

1. **Orden sugerido de pruebas**:
   - Primero: Login exitoso con "admin"
   - Segundo: Login exitoso con "user"
   - Tercero: Login fallido con credenciales incorrectas

2. **Mostrar el WSDL**: Abre `http://localhost:8080/ws/login.wsdl` en el navegador para mostrar el contrato del servicio

3. **Logs del servidor**: Los logs en la consola muestran cada peticion recibida

4. **Comparar Request vs Response**: Muestra como el XML del request se transforma en el response

---

## Credenciales Validas para Pruebas

| Usuario | Password | Status Esperado |
|---------|----------|----------------|
| admin   | admin123 | SUCCESS        |
| user    | user123  | SUCCESS        |
| test    | test123  | SUCCESS        |
| (cualquier otro) | (cualquier password) | FAILURE |

---

## Comando CURL Rapido (Alternativa a Postman)

Si quieres probar rapidamente desde la terminal:

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml" \
  -H "SOAPAction: \"\"" \
  -d '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://www.example.com/soap-login-service"><soapenv:Header/><soapenv:Body><soap:LoginRequest><soap:username>admin</soap:username><soap:password>admin123</soap:password></soap:LoginRequest></soapenv:Body></soapenv:Envelope>'
```

---

Buena suerte con tu demostracion!
