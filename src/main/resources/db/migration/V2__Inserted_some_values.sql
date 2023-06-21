INSERT INTO manufacturers
  (id, name)
VALUES
  (0, 'Manufacturer A');

INSERT INTO car_models
  (id, model, manufacturer_id, seats, fuel_type, transmission_type)
VALUES
  (0, 'Model A', 0, 4, 'ELECTRIC', 'AUTOMATIC');

INSERT INTO car_sharing_companies
  (id, name, description, address)
VALUES
  (0, 'CarShare A', 'Some description', 'Some address');

INSERT
INTO
  support_phones
  (car_sharing_company_id, support_phone)
VALUES
  (0, '375123421234'),
  (0, '375256312342'),
  (0, '375134647581');

INSERT INTO registered_cars
  (id, license_plate_number, car_sharing_company_id, car_model_id, price_per_minute, is_available, car_location_latitude, car_location_longitude)
VALUES
  (0, 'PLATEEXAMPLE1', 0, 0, 25.26, FALSE, 25.2136, 41.23654);