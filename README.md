# Envanter Yönetim Sistemi

Bu, Java Final projesi için çeşitli Java programlama kavramlarını gösteren kapsamlı bir Java projesidir.

## Proje Genel Bakış

Envanter Yönetim Sistemi, kullanıcıların ürün ve kategorileri yönetmelerine olanak tanıyan bir Spring Boot uygulamasıdır. İçeriği:

- CRUD işlemleri için RESTful API uç noktaları
- Çeşitli Java programlama kavramlarının gösterimi

## Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- Hibernate
- Maven
- Docker ve Docker Compose
- Swagger/OpenAPI (API dokümantasyonu için)

## Gösterilen Java Kavramları

1. **Temel Java Konuları**
   - Nesne yönelimli programlama
   - Kalıtım ve polimorfizm
   - İstisna yönetimi

2. **Gelişmiş Java Konuları**
   - Anotasyonlar
   - Yansıma (Spring Framework aracılığıyla)
   - Java Beans

3. **Java 8 Fonksiyonel Programlama**
   - Lambda ifadeleri
   - Streams API
   - Fonksiyonel arayüzler
   - Metot referansları

4. **Kalıtım ve Veri Yapıları**
   - Sınıf kalıtımı
   - Koleksiyon Çerçevesi (Listeler, Haritalar)
   - OOP prensipleri

5. **Sıralama ve Arama Algoritmaları**
   - Birleştirme sıralaması (Merge sort)
   - Hızlı sıralama (Quick sort)
   - İkili arama (Binary search)
   - Kova sıralaması (Bucket sort)

6. **Jenerik Programlama**
   - Jenerik arayüzler
   - Tip parametreleri
   - Sınırlı tip parametreleri

7. **Çok İş Parçacıklı Programlama**
   - İş parçacığı havuzları
   - Eşzamanlı koleksiyonlar
   - CompletableFuture
   - Paralel işleme

8. **Veritabanı Bağlantısı**
   - PostgreSql


9. **J2EE Temelleri**
   - Servletler (Spring MVC aracılığıyla)
   - Bağımlılık Enjeksiyonu
   - Kontrolün Tersine Çevrilmesi

10. **Web Programlama (API)**
    - RESTful API tasarımı
    - HTTP metodları
    - JSON serileştirme/serileştirmekten çözme

11. **Popüler Java Kütüphaneleri ve Çerçeveleri**
    - Spring Boot
    - Spring Data
    - Maven

## Başlarken

### Ön Koşullar

- Java 17 veya üstü
- Maven
- Docker ve Docker Compose (konteynerleştirilmiş dağıtım için)

### Yerel Olarak Çalıştırma

1. Depoyu klonlayın
2. Proje dizinine gidin
3. Uygulamayı çalıştırın:
   ```
   ./mvnw spring-boot:run
   ```

4. Uygulamaya erişin:

   https://ilerijava-production.up.railway.app/api/      bu uygulama nın deploy adresidir

   https://ilerijava-production.up.railway.app/api/categories adresi ile kategoriler servis adresi

   https://ilerijava-production.up.railway.app/api/products ürünler servis adresidir

 

### Docker ile Çalıştırma

1. Docker Compose kullanarak oluşturun ve çalıştırın:
   ```
   docker-compose up -d
   ```

2. Uygulamaya http://localhost:8080 adresinden erişin

Postman ile örnek test görüntüsü categories alanına ekleme yapılmıştır
![Ekran görüntüsü 2025-06-07 173441](https://github.com/user-attachments/assets/32b9667c-db8a-4252-960b-cee29fc8bf09)



Eklediğimiz ürün get ile listeleme alanında gözükmektedir
![Ekran görüntüsü 2025-06-07 173437](https://github.com/user-attachments/assets/bf7fa52e-3951-4a23-8d8c-afdfb508aa4d)



İd'si 1 olan kategorinin  ve açıklama alanını güncelleme işlemi
![Ekran görüntüsü 2025-06-11 112406](https://github.com/user-attachments/assets/9698dabb-df07-4f1a-9b4a-ab9ea1e6bb59)

Kategoriler kısmında arama yapılmıştır sonuç listelenmiştir
![Ekran görüntüsü 2025-06-11 212613](https://github.com/user-attachments/assets/f199f7d6-bff0-4035-8f4a-2b4c2a3f85c9)





## API Uç Noktaları

### Ürünler

- `GET http://ilerijava-production.up.railway.app/api/products` - Tüm ürünleri al
- `GET http://ilerijava-production.up.railway.app/api/products/id` - ID'ye göre ürün al
- `POST http://ilerijava-production.up.railway.app/api/products` - Yeni bir ürün oluştur
- `PUT http://ilerijava-production.up.railway.app/api/products/id` - Bir ürünü güncelle
- `DELETE http://ilerijava-production.up.railway.app/api/products/id` - Bir ürünü sil
- `GET http://ilerijava-production.up.railway.app/api/products/category/categoryId` - Kategoriye göre ürünleri al
- `GET http://ilerijava-production.up.railway.app/api/products/search?name=name` - İsme göre ürün ara
- `GET http://ilerijava-production.up.railway.app/api/products/price-range?minPrice=min&maxPrice=max` - Fiyat aralığına göre ürünleri al
- `GET http://ilerijava-production.up.railway.app/api/products/low-stock` - Düşük stoktaki ürünleri al
- `PATCH http://ilerijava-production.up.railway.app/api/products/id/quantity?quantity=quantity` - Ürün miktarını güncelle

### Kategoriler

- `GET http://ilerijava-production.up.railway.app/api/categories` - Tüm kategorileri al
- `GET http://ilerijava-production.up.railway.app/api/categories/id` - ID'ye göre kategori al
- `POST http://ilerijava-production.up.railway.app/api/categories` - Yeni bir kategori oluştur
- `PUT http://ilerijava-production.up.railway.app/api/categories/id` - Bir kategoriyi güncelle
- `DELETE http://ilerijava-production.up.railway.app/api/categories/id` - Bir kategoriyi sil
- `GET http://ilerijava-production.up.railway.app/api/categories/search?name=name` - İsme göre kategori ara

## Dağıtım

Uygulama çeşitli bulut platformlarına dağıtılabilir:

- **Docker**: Sağlanan Dockerfile ve docker-compose.yml dosyalarını kullanın
- **Railway**: Otomatik dağıtım için GitHub deponuzu Railway'e bağlayın
- **AWS**: AWS Elastic Beanstalk veya ECS kullanarak dağıtın

## Örnek JSON Şemaları

API ile etkileşim için kullanabileceğiniz örnek JSON şemaları aşağıda verilmiştir:

### Kategori Oluşturma (POST /api/categories)
```json
{
  "name": "Bilgisayarlar",
  "description": "Masaüstü ve dizüstü bilgisayarlar"
}
```

### ID'ye göre kategori Güncelleme (PUT /api/categories/{id})
```json
{
  "name": "Bilgisayarlar",
  "description": "Masaüstü, dizüstü ve tablet bilgisayarlar"
}
```

### Ürün Oluşturma (POST /api/products)
```json
{
  "name": "Gaming Laptop",
  "description": "Yüksek performanslı oyuncu bilgisayarı",
  "price": 25000.00,
  "quantity": 12,
  "category": {
    "id": 1
  }
}
```

### Ürün Güncelleme (PUT /api/products/{id})
```json
{
  "name": "Gaming Laptop Pro",
  "description": "Ultra performans oyuncu bilgisayarı",
  "price": 27500.00,
  "quantity": 8,
  "category": {
    "id": 1
  }
}


```

### Fiyat Aralığına Göre Ürün Arama (GET /api/products/price-range)
```
/api/products/price-range?minPrice=5000&maxPrice=20000
```

### Kategoriye Göre Ürün Arama (GET /api/products/category/{categoryId})
```
/api/products/category/1
```

