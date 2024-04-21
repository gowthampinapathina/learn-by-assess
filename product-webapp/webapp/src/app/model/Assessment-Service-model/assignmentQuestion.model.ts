import { LearnerAnswer } from "./learnerAnswer.model";
import { Option } from "./option.model";

export class AssignmentQuestion {
    questionId: number;
    questionType: string;
    questionStem: string;
    comments: string;
    questionLevel: string;
    questionMark: number;
    optionsStatus: Option[];
    correctAnswer: string;
    learnerAnswers: LearnerAnswer[]; 
}