package com.vmb.enterprise.langpack.java17;

public class TextBlockExample {

    public static void main(String... args){
        var xmlTextBock = """
                <!DOCTYPE glossary PUBLIC "-//OASIS//DTD DocBook V3.1//EN">
                 <glossary><title>example glossary</title>
                  <GlossDiv><title>S</title>
                   <GlossList>
                    <GlossEntry ID="SGML" SortAs="SGML">
                     <GlossTerm>Standard Generalized Markup Language</GlossTerm>
                     <Acronym>SGML</Acronym>
                     <Abbrev>ISO 8879:1986</Abbrev>
                     <GlossDef>
                      <para>A meta-markup language, used to create markup
                languages such as DocBook.</para>
                      <GlossSeeAlso OtherTerm="GML">
                      <GlossSeeAlso OtherTerm="XML">
                     </GlossDef>
                     <GlossSee OtherTerm="markup">
                    </GlossEntry>
                   </GlossList>
                  </GlossDiv>
                 </glossary>
                """;

        System.out.println("xmlTextBock::"+xmlTextBock);
    }
}
