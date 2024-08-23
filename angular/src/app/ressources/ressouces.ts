export interface Ressources {
    idRessource?: number; 
    name: string;
    category: string;
    type: string;
    statusMaintenance: string;
    description: string;
    status: string;
}
export interface Equipment extends Ressources{
    price: string;
    quantity: string;
    manifucturer : string;
    model: string;
}
export interface Room extends Ressources{
    location: string;
    capacity : string;
}