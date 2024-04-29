use("hospital");
// db.patient.insertMany([
//   {firstname: "John",
//    lastname: "Smith",
//     age: 21,
//     history: [
//       {desease: "rhume",
//      treament : "sirop"},
//      {desease: "grippe",
//     treament : "anti-biotique"}
// ]},
// {firstname: "Julie",
//    lastname: "Dubois",
//     age: 28,
//     history: [
//       {desease: "migraine",
//      treament : "comprimé"},
//      {desease: "nausée",
//     treament : "sirop"}
// ]},
// {firstname: "Pauline",
//    lastname: "Laout",
//     age: 31,
//     history: [
//       {desease: "migraine",
//      treament : "Whisky_ coca"},
//      {desease: "nausée",
//     treament : "canard-laqué"}
// ]}
// ]
// );

//db.patient.find();

// db.patient.find({firstname: "Julie"});
// db.patient.updateOne({firstName: "Juile"}, {$set: {lastName: "Dupont", age: 18, history: [{desease: "depression", treatment: "pas de sommeil"}]}});
 
//--Trouver tous les patients qui ont un âge supérieur à 29 ans.
 db.patient.find({age:{$gt : 29}});

// --Supprimer tous les patients qui ont attrapé un rhume comme une maladie.
// db.patient.deleteMany({"history.desease": "rhume"});

// db.patient.deleteMany({"history.desease": "rhume"});

// db.patient.insertOne(
//     {firstname: "John",
//      lastname: "Smith",
//       age: 21,
//       history: [
//         {desease: "rhume",
//        treament : "sirop"},
//        {desease: "grippe",
//       treament : "anti-biotique"}
//   ]})