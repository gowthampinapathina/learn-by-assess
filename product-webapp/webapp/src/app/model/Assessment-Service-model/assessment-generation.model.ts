import { Assignment } from "./assignment.model";

export class AssessmentGeneration{
    batchId:string = '';
    instructorName:string = '';
    instructorEmailId:string = '';
    assignments: Assignment[] =[];
    participants: Participant[];
}

export class Participant{
    mailId: string;
    score: number;
    assignmentStatus: string ;
}









