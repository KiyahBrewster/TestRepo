-- ingredients
INSERT INTO ingredient (id, name) VALUES
(1,'pasta'),(2,'tomato'),(3,'cheese'),
(4,'broccoli'),(5,'carrot'),(6,'soy sauce'),
(7,'egg'),(8,'rice'),(9,'green onion');

-- original 3 recipes (basic structure, with nulls for missing columns)
INSERT INTO recipe (id, name, instructions, image_url, prep_minutes, cook_minutes, ingredients_text) VALUES
(1,'Pasta Salad','Boil pasta, mix with tomato & cheese.','',NULL,NULL,NULL),
(2,'Veggie Stir Fry','Stir fry broccoli & carrot, add soy sauce.','',NULL,NULL,NULL),
(3,'Egg Fried Rice','Fry egg, add rice and soy sauce, finish with green onion.','',NULL,NULL,NULL);

-- join table for original 3
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES
(1,1),(1,2),(1,3),
(2,4),(2,5),(2,6),
(3,7),(3,8),(3,6),(3,9);

-- backfill new fields for the first 3 so the UI has times/images/ingredients
UPDATE recipe
SET prep_minutes = 10,
    cook_minutes = 10,
    ingredients_text = 'pasta; tomatoes; cheese; olive oil; salt and pepper',
    image_url = 'https://images.unsplash.com/photo-1526318472351-c75fcf070305?q=80&w=1600&auto=format&fit=crop'
WHERE id = 1;

UPDATE recipe
SET prep_minutes = 12,
    cook_minutes = 8,
    ingredients_text = 'broccoli; carrot; soy sauce; garlic; oil; salt',
    image_url = 'https://images.unsplash.com/photo-1498654896293-37aacf113fd9?q=80&w=1600&auto=format&fit=crop'
WHERE id = 2;

UPDATE recipe
SET prep_minutes = 5,
    cook_minutes = 10,
    ingredients_text = 'egg; rice; soy sauce; green onion; oil; salt and pepper',
    image_url = 'https://images.unsplash.com/photo-1551183053-bf91a1d81141?q=80&w=1600&auto=format&fit=crop'
WHERE id = 3;

-- new recipes 4-15 (all fields filled)
INSERT INTO recipe (id, name, instructions, image_url, prep_minutes, cook_minutes, ingredients_text) VALUES
(4,'Lemon Garlic Chicken Bowl',
 'Season chicken with salt, pepper, and lemon zest. Saute garlic in oil; add chicken and cook until golden. Finish with lemon juice and serve over cooked rice.',
 'https://images.unsplash.com/photo-1512058564366-18510be2db19?q=80&w=1600&auto=format&fit=crop',
 15,25,
 '2 chicken breasts (cubed); 2 tbsp olive oil; 3 cloves garlic (minced); 1 lemon (zest and juice); 1 cup cooked rice; salt and pepper'
),
(5,'Spicy Shrimp Tacos',
 'Toss shrimp with chili powder and salt. Sear 2-3 min per side. Fill tortillas with shrimp, slaw, cilantro, and lime.',
 'https://images.unsplash.com/photo-1552332386-f8dd00dc2f85?q=80&w=1600&auto=format&fit=crop',
 10,10,
 '1 lb shrimp; 2 tsp chili powder; 8 small tortillas; slaw mix; lime; cilantro; salt'
),
(6,'Veggie Fried Rice',
 'Scramble eggs; set aside. Stir-fry mixed veggies; add rice, soy sauce, and sesame oil. Fold in eggs and serve hot.',
 'https://images.unsplash.com/photo-1551183053-bf91a1d81141?q=80&w=1600&auto=format&fit=crop',
 10,12,
 '3 cups day-old rice; 2 eggs; 1 cup mixed veggies; 2 tbsp soy sauce; 1 tsp sesame oil'
),
(7,'Beef Stir-Fry',
 'Sear sliced flank steak in a hot wok; remove. Stir-fry onion and bell pepper; return steak with oyster and soy sauce. Toss 1-2 min and serve over rice.',
 'https://images.unsplash.com/photo-1496116835401-15d9d3f3c76f?q=80&w=1600&auto=format&fit=crop',
 15,10,
 '12 oz flank steak (sliced); 1 bell pepper; 1 small onion; 2 tbsp oyster sauce; 1 tbsp soy sauce; cooked rice'
),
(8,'Tomato Basil Pasta',
 'Boil pasta until al dente. Saute garlic and tomatoes; toss pasta. Finish with basil and parmesan.',
 'https://images.unsplash.com/photo-1526318472351-c75fcf070305?q=80&w=1600&auto=format&fit=crop',
 5,15,
 '8 oz pasta; 2 cups cherry tomatoes; 2 cloves garlic; fresh basil; parmesan; salt'
),
(9,'Greek Chicken Salad',
 'Grill or pan-sear chicken and slice. Assemble salad with romaine, cucumbers, tomatoes, olives, and feta. Drizzle with Greek dressing.',
 'https://images.unsplash.com/photo-1546069901-eacef0df6022?q=80&w=1600&auto=format&fit=crop',
 15,12,
 '2 chicken breasts; romaine; cucumbers; tomatoes; kalamata olives; feta; Greek dressing'
),
(10,'BBQ Pulled Pork Sandwich',
 'Slow-cook pork until shreddable. Toss with BBQ sauce. Serve on buns with coleslaw.',
 'https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=1600&auto=format&fit=crop',
 10,240,
 '2 lb pork shoulder; BBQ sauce; buns; coleslaw; salt and pepper'
),
(11,'Shakshuka',
 'Simmer tomatoes with spices and peppers. Crack eggs into sauce; cover until set. Garnish with parsley.',
 'https://images.unsplash.com/photo-1617196033595-1e75d9b02c21?q=80&w=1600&auto=format&fit=crop',
 10,20,
 '1 can crushed tomatoes; 1 bell pepper; 4 eggs; paprika; cumin; parsley; salt'
),
(12,'Teriyaki Salmon',
 'Brush salmon with teriyaki sauce. Bake at 400F for 12-15 min. Top with sesame seeds and green onions.',
 'https://images.unsplash.com/photo-1506368249639-73a05d6f6488?q=80&w=1600&auto=format&fit=crop',
 10,15,
 '4 salmon fillets; teriyaki sauce; sesame seeds; green onions'
),
(13,'Chickpea Curry',
 'Saute onion and garlic. Stir in curry paste, chickpeas, and coconut milk. Simmer 10-15 min and serve with rice.',
 'https://images.unsplash.com/photo-1604908554027-912b9d55b66b?q=80&w=1600&auto=format&fit=crop',
 10,20,
 '1 can chickpeas; 1 onion; 2 cloves garlic; curry paste; 1 can coconut milk; salt'
),
(14,'Caprese Panini',
 'Layer mozzarella, tomato, and basil on ciabatta. Press until melted and crisp. Drizzle with balsamic glaze.',
 'https://images.unsplash.com/photo-1544025161-ec9b1b5b1f25?q=80&w=1600&auto=format&fit=crop',
 8,6,
 'ciabatta; fresh mozzarella; tomatoes; basil; balsamic glaze; olive oil'
),
(15,'Overnight Oats',
 'Combine oats, milk, and chia; refrigerate overnight. Top with fruit and honey before serving.',
 'https://images.unsplash.com/photo-1517677208171-0bc6725a3e60?q=80&w=1600&auto=format&fit=crop',
 5,0,
 '1/2 cup rolled oats; 1/2 cup milk; 1 tbsp chia; fruit; honey'
);
