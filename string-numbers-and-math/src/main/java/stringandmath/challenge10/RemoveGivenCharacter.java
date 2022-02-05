package stringandmath.challenge10;

import commons.utils.executionutil.Approach;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public final class RemoveGivenCharacter {
   private RemoveGivenCharacter(){
      throw new AssertionError("Class cannot be instantiated.");
   }

   public static List<Approach<String>> approaches = List.of(new StringUtilityApproach(), new FunctionalStyleBased());

   static class StringUtilityApproach implements Approach<String>{

      @Override
      public String getDescription() {
         return "RemoveGivenCharacter: String class utility method approach";
      }

      @Override
      public String apply(Object... args) {
         String input = (String)args[0];
         String symbolToRemove = (String)args[1];

         sanitizeInput(input, symbolToRemove);

//         String patternToRemove = symbolToRemove; This will fail for reserved REGEX characters such as '.', '*', etc
         String patternToRemove = Pattern.quote(symbolToRemove);
         return input.replaceAll(patternToRemove, "");
      }
   }

   static class FunctionalStyleBased implements Approach<String> {

      @Override
      public String getDescription() {
         return "RemoveGivenCharacter: Functional style based solution";
      }

      @Override
      public String apply(Object... args) {
         String input = (String)args[0];
         String symbolToRemove = (String)args[1];

         sanitizeInput(input, symbolToRemove);
         Predicate<String> removeMatch = symbol -> symbol.equals(symbolToRemove);

         return input.codePoints()
                 .mapToObj(Character::toString)
                 .filter(removeMatch.negate())
                 .collect(
                         joining()
                 );
      }

   }

   private static void sanitizeInput(String input, String symbolToRemove) {
      if(input == null || input.isEmpty()){
         throw new IllegalArgumentException("Input string cannot be null/empty");
      }

      if(symbolToRemove == null){
         throw new IllegalArgumentException("Search string cannot be null");
      }

      if(symbolToRemove.codePointCount(0, symbolToRemove.length()) > 1){
         throw new IllegalArgumentException("Search string contains multiple symbols");
      }
   }

}
