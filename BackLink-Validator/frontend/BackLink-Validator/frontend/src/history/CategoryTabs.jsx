const categories = [
  "SOCIAL_MEDIA",
  "EDUCATIONAL",
  "ECOMMERCE",
  "TOOLS",
  "CAR_WEBSITES",
  "PHONE_WEBSITES",
  "OTHER"
];

export default function CategoryTabs({ category, setCategory }) {

  return (
    <div className="flex flex-wrap gap-3 mb-6">

      {categories.map((c) => (
        <button
          key={c}
          onClick={() => setCategory(c)}
          className={`px-4 py-2 rounded transition ${
            category === c
              ? "bg-sky-500 text-black"
              : "bg-slate-800 text-white"
          }`}
        >
          {c}
        </button>
      ))}

    </div>
  );
}