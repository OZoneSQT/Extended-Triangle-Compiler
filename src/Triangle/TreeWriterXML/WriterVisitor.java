package Triangle.TreeWriterXML;


import Triangle.AbstractSyntaxTrees.*;

import java.io.FileWriter;
import java.io.IOException;

public class WriterVisitor implements Visitor {

    private FileWriter fileWriter;

    WriterVisitor(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    // Commands
    public Object visitAssignCommand(AssignCommand ast, Object obj) {
        writeTag("<AssignCommand>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</AssignCommand>");
        return null;
    }

    public Object visitCallCommand(CallCommand ast, Object obj) {
        writeTag("<CallCommand>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeTag("</CallCommand>");
        return null;
    }

    public Object visitEmptyCommand(EmptyCommand ast, Object obj) {
        writeTag("<EmptyCommand/>");
        return null;
    }

    public Object visitIfCommand(IfCommand ast, Object obj) {
        writeTag("<IfCommand>");
        ast.E.visit(this, null);
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeTag("</IfCommand>");
        return null;
    }

    public Object visitLetCommand(LetCommand ast, Object obj) {
        writeTag("<LetCommand>");
        ast.D.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</LetCommand>");
        return null;
    }

    public Object visitSequentialCommand(SequentialCommand ast, Object obj) {
        writeTag("<SequentialCommand>");
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeTag("</SequentialCommand>");
        return null;
    }

    public Object visitWhileCommand(WhileCommand ast, Object obj) {
        writeTag("<WhileCommand>");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</WhileCommand>");
        return null;
    }

    public Object visitEndRestOfIf(EndRestOfIF ast, Object o) {
        writeTag("<RestOfIf>");
        ast.C.visit(this, null);
        writeTag("</RestOfIf");
        return null;
    }

    @Override
    public Object visitCondRestOfIf(CondRestOfIf ast, Object o) {
        writeTag("<RestOfIf>");
        ast.C.visit(this, null);
        writeTag("</RestOfIf");
        return null;
    }

    @Override
    public Object visitRepeatDoWhileCommand(RepeatDoWhileCommand ast, Object o) {
        writeTag("<RepeatDoWhileCommand>");
        ast.C.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</RepeatDoWhileCommand>");
        return null;
    }

    @Override
    public Object visitRepeatWhileCommand(RepeatWhileCommand ast, Object o) {
        writeTag("<RepeatWhileCommand>");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</RepeatWhileCommand>");
        return null;
    }

    @Override
    public Object visitRepeatUntilCommand(RepeatUntilCommand ast, Object o) {
        writeTag("<RepeatUntilCommand>");
        ast.E.visit(this, null);
        ast.C.visit(this, null);
        writeTag("<RepeatUntilCommand>");
        return null;
    }

    @Override
    public Object visitRepeatDoUntilCommand(RepeatDoUntilCommand ast, Object o) {
        writeTag("<RepeatDoUntilCommand>");
        ast.C.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</RepeatDoUntilCommand>");
        return null;
    }

    @Override
    public Object visitRepeatForRangeWhileCommand(RepeatForRangeWhileCommand ast, Object o) {
        writeTag("<RepeatForRangeWhileCommand>");
        ast.RVD.visit(this, null);
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        writeTag("</RepeatForRangeWhileCommand>");
        return null;
    }

    @Override
    public Object visitRepeatForRangeUntilCommand(RepeatForRangeUntilCommand ast, Object o) {
        writeTag("<RepeatForRangeUntilCommand>");
        ast.RVD.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</RepeatForRangeUntilCommand>");
        return null;
    }

    @Override
    public Object visitRepeatForRangeDoCommand(RepeatForRangeDoCommand ast, Object o) {
        writeTag("<RepeatForRangeDoCommand>");
        ast.RVD.visit(this, null);
        ast.E2.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</RepeatForRangeDoCommand>");
        return null;
    }

    @Override
    public Object visitRepeatForInCommand(RepeatForInCommand ast, Object o) {
        writeTag("<RepeatForInCommand>");
        ast.IVD.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</RepeatForInCommand>");
        return null;
    }


    // Expressions
    public Object visitArrayExpression(ArrayExpression ast, Object obj) {
        writeTag("<ArrayExpression>");
        ast.AA.visit(this, null);
        writeTag("</ArrayExpression>");
        return null;
    }

    public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
        writeTag("<BinaryExpression>");
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);
        writeTag("</BinaryExpression>");
        return null;
    }

    public Object visitCallExpression(CallExpression ast, Object obj) {
        writeTag("<CallExpression>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeTag("</CallExpression>");
        return null;
    }

    public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
        writeTag("<CharacterExpression>");
        ast.CL.visit(this, null);
        writeTag("</CharacterExpression>");
        return null;
    }

    public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
        writeTag("<EmptyExpression/>");
        return null;
    }

    public Object visitIfExpression(IfExpression ast, Object obj) {
        writeTag("<IfExpression>");
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        writeTag("</IfExpression>");
        return null;
    }

    public Object visitIntegerExpression(IntegerExpression ast, Object obj) {
        writeTag("<IntegerExpression>");
        ast.IL.visit(this, null);
        writeTag("</IntegerExpression>");
        return null;
    }

    public Object visitLetExpression(LetExpression ast, Object obj) {
        writeTag("<LetExpression>");
        ast.D.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</LetExpression>");
        return null;
    }

    public Object visitRecordExpression(RecordExpression ast, Object obj) {
        writeTag("<RecordExpression>");
        ast.RA.visit(this, null);
        writeTag("</RecordExpression>");
        return null;
    }

    public Object visitUnaryExpression(UnaryExpression ast, Object obj) {
        writeTag("<UnaryExpression>");
        ast.O.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</UnaryExpression>");
        return null;
    }

    public Object visitVnameExpression(VnameExpression ast, Object obj) {
        writeTag("<VnameExpression>");
        ast.V.visit(this, null);
        writeTag("</VnameExpression>");
        return null;
    }


    // Declarations
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object obj) {
        writeTag("<BinaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG1.visit(this, null);
        ast.ARG2.visit(this, null);
        ast.RES.visit(this, null);
        writeTag("</BinaryOperatorDeclaration>");
        return null;
    }

    public Object visitConstDeclaration(ConstDeclaration ast, Object obj) {
        writeTag("<ConstDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</ConstDeclaration>");
        return null;
    }

    public Object visitFuncDeclaration(FuncDeclaration ast, Object obj) {
        writeTag("<FuncDeclaration>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</FuncDeclaration>");
        return null;
    }

    public Object visitProcDeclaration(ProcDeclaration ast, Object obj) {
        writeTag("<ProcDeclaration>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.C.visit(this, null);
        writeTag("</ProcDeclaration>");
        return null;
    }

    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object obj) {
        writeTag("<SequentialDeclaration>");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
        writeTag("</SequentialDeclaration>");
        return null;
    }

    @Override
    public Object visitSequentialProcFunc(SequentialProcFunc ast, Object o) {
        return null;
    }

    public Object visitTypeDeclaration(TypeDeclaration ast, Object obj) {
        writeTag("<TypeDeclaration>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeTag("</TypeDeclaration>");
        return null;
    }

    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object obj) {
        writeTag("<UnaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG.visit(this, null);
        ast.RES.visit(this, null);
        writeTag("</UnaryOperatorDeclaration>");
        return null;
    }

    public Object visitVarDeclaration(VarDeclaration ast, Object obj) {
        writeTag("<VarDeclaration>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeTag("</VarDeclaration>");
        return null;
    }

    @Override
    public Object visitLocalDeclaration(LocalDeclaration ast, Object o) {
        writeTag("<LocalDeclaration>");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
        writeTag("</LocalDeclaration>");
        return null;
    }

    @Override
    public Object visitRecursiveDeclaration(RecursiveDeclaration ast, Object o) {
        writeTag("<RecursiveDeclaration>");
        ast.PF.visit(this, null);
        writeTag("</RecursiveDeclaration>");
        return null;
    }

    @Override
    public Object visitVarExpressionDeclaration(VarExpressionDeclaration ast, Object o) {
        writeTag("<VarExpressionDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</VarExpressionDeclaration>");
        return null;
    }

    @Override
    public Object visitRangeVarDeclaration(RangeVarDeclaration ast, Object o) {
        writeTag("<RangeVarDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</RangeVarDeclaration>");
        return null;
    }

    @Override
    public Object visitInVarDeclaration(InVarDeclaration ast, Object o) {
        writeTag("<InVarDeclaration>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</InVarDeclaration>");
        return null;
    }


    // Array Aggregates
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
        writeTag("<MultipleArrayAggregate>");
        ast.E.visit(this, null);
        ast.AA.visit(this, null);
        writeTag("</MultipleArrayAggregate>");
        return null;
    }

    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
        writeTag("<SingleArrayAggregate>");
        ast.E.visit(this, null);
        writeTag("</SingleArrayAggregate>");
        return null;
    }


    // Record Aggregates
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
        writeTag("<MultipleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        ast.RA.visit(this, null);
        writeTag("</MultipleRecordAggregate>");
        return null;
    }

    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
        writeTag("<SingleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</SingleRecordAggregate>");
        return null;
    }


    // Formal Parameters
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {
        writeTag("<ConstFormalParameter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeTag("</ConstFormalParameter>");
        return null;
    }

    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
        writeTag("<FuncFormalParameter>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        writeTag("<FuncFormalParameter>");
        return null;
    }

    public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
        writeTag("<ProcFormalParameter>");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        writeTag("</ProcFormalParameter>");
        return null;
    }

    public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
        writeTag("<VarFormalParameter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeTag("</VarFormalParameter>");
        return null;
    }


    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
        writeTag("<EmptyFormalParameterSequence/>");
        return null;
    }

    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
        writeTag("<MultipleFormalParameterSequence>");
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);
        writeTag("</MultipleFormalParameterSequence>");
        return null;
    }

    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
        writeTag("<SingleFormalParameterSequence>");
        ast.FP.visit(this, null);
        writeTag("</SingleFormalParameterSequence>");
        return null;
    }


    // Actual Parameters
    public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
        writeTag("<ConstActualParameter>");
        ast.E.visit(this, null);
        writeTag("</ConstActualParameter>");
        return null;
    }

    public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
        writeTag("<FuncActualParameter>");
        ast.I.visit(this, null);
        writeTag("</FuncActualParameter>");
        return null;
    }

    public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
        writeTag("<ProcActualParameter>");
        ast.I.visit(this, null);
        writeTag("</ProcActualParameter>");
        return null;
    }

    public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
        writeTag("<VarActualParameter>");
        ast.V.visit(this, null);
        writeTag("</VarActualParameter>");
        return null;
    }


    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
        writeTag("<EmptyActualParameterSequence/>");
        return null;
    }

    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
        writeTag("<MultipleActualParameterSequence>");
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);
        writeTag("</MultipleActualParameterSequence>");
        return null;
    }

    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
        writeTag("<SingleActualParameterSequence>");
        ast.AP.visit(this, null);
        writeTag("</SingleActualParameterSequence>");
        return null;
    }


    // Type Denoters
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
        writeTag("<AnyTypeDenoter/>");
        return null;
    }

    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
        writeTag("<ArrayTypeDenoter>");
        ast.IL.visit(this, null);
        ast.T.visit(this, null);
        writeTag("</ArrayTypeDenoter>");
        return null;
    }

    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) {
        writeTag("<BoolTypeDenoter/>");
        return null;
    }

    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) {
        writeTag("<CharTypeDenoter/>");
        return null;
    }

    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) {
        writeTag("<ErrorTypeDenoter/>");
        return null;
    }

    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
        writeTag("<SimpleTypeDenoter>");
        ast.I.visit(this, null);
        writeTag("</SimpleTypeDenoter>");
        return null;
    }

    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) {
        writeTag("<IntTypeDenoter/>");
        return null;
    }

    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
        writeTag("<RecordTypeDenoter>");
        ast.FT.visit(this, null);
        writeTag("</RecordTypeDenoter>");
        return null;
    }


    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
        writeTag("<MultipleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        ast.FT.visit(this, null);
        writeTag("</MultipleFieldTypeDenoter>");
        return null;
    }

    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
        writeTag("<SingleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeTag("</SingleFieldTypeDenoter>");
        return null;
    }


    // Literals, Identifiers and Operators
    public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) {
        writeTag("<CharacterLiteral value=\"" + ast.spelling + "\"/>");
        return null;
    }

    public Object visitIdentifier(Identifier ast, Object obj) {
        writeTag("<Identifier value=\"" + ast.spelling + "\"/>");
        return null;
    }

    public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) {
        writeTag("<IntegerLiteral value=\"" + ast.spelling + "\"/>");
        return null;
    }

    public Object visitOperator(Operator ast, Object obj) {
        writeTag("<Operator value=\"" + transformOperator(ast.spelling) + "\"/>");
        return null;
    }


    // Value-or-variable names
    public Object visitDotVname(DotVname ast, Object obj) {
        writeTag("<DotVname>");
        ast.V.visit(this, null);
        ast.I.visit(this, null);
        writeTag("</DotVname>");
        return null;
    }

    public Object visitSimpleVname(SimpleVname ast, Object obj) {
        writeTag("<SimpleVname>");
        ast.I.visit(this, null);
        writeTag("</SimpleVname>");
        return null;
    }

    public Object visitSubscriptVname(SubscriptVname ast, Object obj) {
        writeTag("<SubscriptVname>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeTag("</SubscriptVname>");
        return null;
    }


    // Programs
    public Object visitProgram(Program ast, Object obj) {
        writeTag("<Program>");
        ast.C.visit(this, null);
        writeTag("</Program>");
        return null;
    }

    private void writeTag(String line) {
        try {
            fileWriter.write(line);
            fileWriter.write('\n');
        } catch (IOException e) {
            System.err.println("Error while writing file for print the AST");
            e.printStackTrace();
        }
    }

    /*
     * Convert the characters "<" & "<=" to their equivalents in html
     */
    private String transformOperator(String operator) {
        if (operator.compareTo("<") == 0)
            return "&lt;";
        else if (operator.compareTo("<=") == 0)
            return "&lt;=";
        else
            return operator;
    }

}