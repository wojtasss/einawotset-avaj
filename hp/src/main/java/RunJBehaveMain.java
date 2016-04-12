
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;

public class RunJBehaveMain {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("HashStory.story");
	
	public static void main(String[] args) {
		embedder.configuration().useStoryLoader(new LoadFromClasspath())
		  .useStoryReporterBuilder(new StoryReporterBuilder()
				  .withDefaultFormats() 
				    .withFormats(Format.CONSOLE, Format.TXT));
		embedder.candidateSteps().add(new MySteps());
		embedder.runStoriesAsPaths(storyPaths);
	
		/*Hash hash = new Hash();
		hash.addInt(5);
		System.out.println(hash.searchInt(5));
		System.out.println(Arrays.toString(hash.getArray()));*/
	}
}
