// aggregation:

use("restau");

// db.restaurant.aggregate({$match: {rating:5}});

// -- récupère le nombre de resto rating 5 
// db.restaurant.aggregate({$match: {rating:5}},{$count : "nbrResto"});

// db.restaurant.aggregate({$match: {rating:5}},{$project : {URL:1, name: 1}});

// --combien restaurant dans même type, il faut une clé unique pour groupby
// db.restaurant.aggregate({$group: {_id: "$type_of_food",count:{$sum:1}}})

// --combien restaurant dans même type,et avoir plus 10
// db.restaurant.aggregate([
//   { $group: { _id: "$type_of_food", count: { $sum: 1 } } },
//   { $match: { count: { $gt: 10 } } },
// ]);

// db.restaurant.aggregate([
//   { $group: { _id: "$type_of_food", count: { $sum: 1 } } },
//   { $match: { count: { $gt: 10 } } },
//   { $sort: { count: -1 } },
// ]);


// db.restaurant.aggregate({
//   $group: { _id: "$postcode", nombre_restaurant: { $sum: 1 } },
// });

// db.restaurant.aggregate({$match :{type_of_food : "Thai", rating: {$gt : 4}}});

// db.restaurant.aggregate([{$match :{type_of_food : "Thai", rating: {$gt : 4}}},{$project :{_id: 0, type_of_food: 1, rating :1}}, {$limit : 3}]);

// db.restaurant.aggregate({$match :{type_of_food : "Caribbean"}},{$count : "no_resto_caribbean"})

// db.restaurant.aggregate({$group:{_id:"$type_of_food", note_moyenne : {$avg: "$rating"}}})

db.restaurant.aggregate([
  {$match: {rating:{$ne: "not yet rated"}}},
  {$group : {_id: "$type_of_food", total_rating : {$sum: "$rating"},
   avg_rating : {$avg : "$rating"}, 
   max_rating : {$max : "$rating"},
   min_rating : {$min : "$rating"}
    }}])




