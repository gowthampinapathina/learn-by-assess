
import { AssignmentQuestion } from "./assignmentQuestion.model";
import { GradingRubrics } from "./gradingRubrics.model";

export class AssignmentTemplate {
    assessmentName: string = '';
    assessmentDiscipline: string = '';
    assessmentStartTime: string = '';
    assessmentEndTime: string = '';  
    rules: string[] = [];
    totalScore: number ;
    status: string = '';
    assessmentConcept: string = '';
    levels: GradingRubrics[];
    questions: AssignmentQuestion[];
}
