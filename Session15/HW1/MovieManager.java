import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieManager<T extends Movie> {
    private List<T> list;

    public MovieManager() {
        this.list = new ArrayList<>();
    }

    public void addMovie(T movie) {
        list.add(movie);
    }

    public boolean removeMovie(String id) {
        return list.removeIf(m -> m.getId().equalsIgnoreCase(id));
    }

    public T findById(String id) {
        for (T m : list) {
            if (m.getId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }

    public List<T> getAllMovies() {
        return list;
    }

    public List<T> searchByTitle(String title) {
        return list.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<T> filterByRating(double minRating) {
        return list.stream()
                .filter(m -> m.getRating() > minRating)
                .collect(Collectors.toList());
    }
}