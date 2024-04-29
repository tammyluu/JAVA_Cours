use("gyme");
// db.sportifs.find();

// 1. Quels sont les sportifs (identifiant, nom et prénom) qui ont un âge entre 20 et 30 ans ?
// db.sportifs.aggregate([
  //db.sportifs.find({ Age: { $gt: 20, $lt: 31 } }, { _id: 1, Nom: 1, Prenom: 1 });


// 2. Quels sont les gymnases de ville “Villetaneuse” ou de “Sarcelles” qui ont une surface de plus de 400 m2 ?

// db.Gymnasses.aggregate([
//   {
//     $match: {
//       $or: [
//         { ville: "VILLETANEUSE" },
//         { ville: "SARCELLES" }
//       ],
//       surface: { $gt: 400 }
//     }
//   }])
  



// 3. Quels sont les sportifs (identifiant et nom) qui pratiquent du handball ?

// db.sportifs.aggregate([
//   {
//     $match: {
//       "Sports.Jouer": "Hand ball"
//     }
//   },
//   {
//     $project: {
//       _id: 1,
//       Nom: 1
     
//     }
//   }
// ])

db.sportifs.find({
    "Sports.Jouer": "Hand ball"
  }, {
    _id: 1,
    Nom: 1
  })
  


// 4. Quels sportifs (identifiant et nom) ne pratiquent aucun sport ?
// db.sportifs.aggregate([
//   {
//     $match: {
//       "Sports.Jouer": { $exists: false }}
//   },
 
//   {
//     $project: {
//       _id: 1,
//       Nom: 1
     
//     }
//   }
// ])

    

  



// 5. Quels gymnases n’ont pas de séances le dimanche ?

// db.Gymnasses.aggregate([
//   {
//     $match: {
//       "Seances.Jour": { $ne: "Dimanche" }
//     }
//   },
//   {
//     $project: { _id : 1, NomGymnase: 1,  Adresse: 1, Ville : 1}} ])
    
     
      
     
   

// 6. Quels gymnases ne proposent que des séances de basket ball ou de volley ball ?
// db.Gymnasses.aggregate([
//   {$match: {
//     "Seances.Libelle": { $all: ["Basket ball", "Volley ball"] }}
//   }])

// db.Gymnasses.find( { "$nor": [ { "Seances.Libelle": { "$ne": "Basket ball"}}, { "Seances.Libelle": { "$ne": "Volley ball" }} ] }, { "_id": 0,"NomGymnase": 1, "Ville": 1, "Seances.Libelle": 1 })
 

// 7. Quels sont les entraîneurs qui sont aussi joueurs ?
// db.sportifs.aggregate([{
//   $match: {
//     $and: [
//       { "Sports.Entrainer": { $exists: true } },
//       { "Sports.Jouer": { $exists: true } }
//     ]
//   }
// }])

// 8. Pour le sportif “Kervadec” quel est le nom de son conseiller ?
// db.sportifs.aggregate([
//   {
//     $match: {
//       Nom: "KERVADEC"
//     }
//   },
//   {
//     $lookup: {
//       from: "sportifs",
//       localField: "IdSportifConseiller",
//       foreignField: "IdSportif",
//       as: "conseiller"
//     }
//   },
  
//   {
//     $project: {
//       _id: 0,
//       NomConseiller: "$conseiller.Nom",
      
//     }
//   }
// ])


// 9. Quelle est la moyenne d’âge des sportives qui pratiquent du basket ball ?
// db.sportifs.aggregate([
//   {
//     $match: {
//       "Sports.Jouer": "Basket ball",
      
//     }
//   },
//   {
//     $group: {
//       _id: null,
//       moyenneAge: { $avg: { $round: ["$Age", 2] } }
//     }
//   }
// ])



// 10.Quels entraîneurs n’entraînent que du hand ball ou du basket ball ?
db.sportifs.aggregate([
  {$match: {
    "Sports.Entrainer": {$in :["Basket ball","Hand ball"]}}}])


// db.sportifs.find({
//   "Sports.Entrainer": { $in: ["Hand ball", "Basket ball"] }
// }, { _id: 1, Nom: 1,Prenom: 1})




// 11. Pour chaque sportif donner le nombre de sports qu’il arbitre?


// db.sportifs.aggregate([
//   {
//     $match: {
//       "_id": "566eec5f662b388eba464203"
//     }
//   },
//   {
//     $project: {
//       _id: 0,
//       Nom: 1,
//       Prenom: 1,
//       NombreArbitres: { $size: { $ifNull: ["$Sports.Arbitrer", []] }}
//     }
//   }
// ])

db.sportifs.find({
  "Sports.Entrainer": { $all: ["Hand ball", "Basket ball"], $size: 2 }
}, {
  _id: 1,
  Nom: 1,
  Prenom: 1
 
})


// db.sportifs.aggregate([
//   {
//     $project: {
//       _id: 0,
//       IdSportif: 1,
//       Nom: 1,
//       Prenom: 1,
//       NombreArbitres: {
//         // vérifier si "Sports.Arbitrer" est un tableau
//         $cond: {
//           if: { $isArray: "$Sports.Arbitrer" },
//           then: { $size: "$Sports.Arbitrer" },
//           else: 0
//         }
//       }
//     }
//   }
// ])


